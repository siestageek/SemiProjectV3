package siestageek.spring.mvc.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Component("fud")
public class FileUpDownUtil {

    // 자바 웹 프로그래밍 파일업로드 지원
    // 1. oreilly사의 '자바 서블릿 프로그래밍' 도서의 예제 - cos.jar
    // 2. apache commons project - FileUpload (추천!)
    //  => commons.apache.org
    // 3. Servlet 3.x부터 파일업로드 내장 - MultipartFile

    // 파일업로드 경로 지정
    private String uploadPath = "c:/Java/pdsupload/";

    // 업로드 처리 메서드1 : commons file upload
    public Map<String, String> procUpload(HttpServletRequest req) {

        Map<String, String> frmdata = new HashMap<>();
        String fname = "";

        // 요청한 폼데이터가 multipart 인지 확인
        RequestContext rctx = new ServletRequestContext(req);
        boolean isMultipart = FileUpload.isMultipartContent(rctx);

        try {
            if (isMultipart) { // 클라이언트 요청이 multipart라면
                // 업로드 처리 객체 생성
                DiskFileItemFactory df = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(df);

                // 클라이언트 요청정보를 리스트에 저장
                List items = upload.parseRequest(req);
                Iterator<FileItem> params = items.iterator();

                // ex) fname => jobs.txt
                // 겹치치 않는 파일명을 위해 유니크한 임의의 값 생성 1
                //UUID uuid = UUID.randomUUID();

                // 겹치치 않는 파일명을 위해 유니크한 임의의 값 생성 2
                String fmt = "yyyyMMddHHmmss";
                SimpleDateFormat sdf = new SimpleDateFormat(fmt);
                String uuid = sdf.format(new Date());
                frmdata.put("uuid", uuid);

                // 리스트에 저장된 요청정보를 하나씩 꺼내서
                // 폼 데이터의 유형에 따라 각각 처리
                while(params.hasNext()) {
                    try {
                        FileItem item = (FileItem) params.next();

                        if (item.isFormField()) { // 텍스트 데이터라면
                            String name = item.getFieldName();
                            String val = item.getString("utf-8");
                            frmdata.put(name, val);  // 맵에 저장
                        } else { // 파일 데이터라면
                            String ufname = item.getName(); // 파일 경로 추출

                            // 첨부파일이 없는 경우 if문 이후 코드 실행 안함
                            if (ufname.equals("") || ufname == null)
                                continue;

                            // ex) ufname => c:\User\Downloads\jobs.txt
                            fname = ufname.substring(
                                    ufname.lastIndexOf("\\") + 1 ); // 파일명 추출

                            // jobs.txt => jobs20210614101812.txt
                            // 즉, 파일명 뒤에 uuid 추가
                            String fnames[] = fname.split("[.]");
                            //fname = fnames[0] + uuid.toString() + "." + fnames[1];
                            fname = fnames[0] + uuid + "." + fnames[1];

                            // ex) fname => jobs123456789.txt
                            // ex) f => c:/Java/pdsupload/jobs123456789.txt
                            File f = new File(uploadPath + "/" + fname);
                            // 업로드한 파일을 시스템에 저장할때는 파일명+uuid 로 설정
                            item.write(f);  // 지정한 경로에 파일 저장

                            String name = item.getFieldName();
                            // 업로드한 파일정보를 디비에 저장할때는 원본파일명 그대로 설정
                            frmdata.put(name, fnames[0] + "." + fnames[1]);


                            // 파일 기타정보 처리
                            long fsize = item.getSize() / 1024;
                            String ftype = fnames[1].toLowerCase();

                            frmdata.put(name+"size", fsize+"");  // 파일크기
                            frmdata.put(name+"type", ftype);     // 파일확장자

                            // 파일명 처리 결과 확인
                            System.out.println(ufname + "/" + fname);
                            System.out.println(fsize + "/" + ftype);
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } // while

            } // if
        } catch (Exception ex) {
            ex.printStackTrace();
        } // try

        return frmdata;
    }

    // 업로드 처리메서드 2 : MultipartFile
    public String procUpload(MultipartFile mf, String uuid) {
        String ofname = mf.getOriginalFilename();  // 원 파일명 가져옴

        // abc.txt : fname[1] => txt
        // abc.123.xyz.txt : fname[3] => txt
        int pos = ofname.lastIndexOf(".");
        String ftype = ofname.substring(pos + 1); // 확장자 추출
        String fname = ofname.substring(0, pos);  // 파일명 추출

        String nfname = fname + uuid + "." + ftype; // 새로운 파일명 생성

        try {
            mf.transferTo(new File(uploadPath + nfname));
            // 지정한 위치에 파일 저장
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ofname + "/" + (mf.getSize() / 1024) + "/" + ftype;
    }

    // 겹치치 않는 파일명을 위해 유니크한 임의의 값 생성
    public String makeUUID() {
        String fmt = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);

        return sdf.format(new Date());
    }

}
