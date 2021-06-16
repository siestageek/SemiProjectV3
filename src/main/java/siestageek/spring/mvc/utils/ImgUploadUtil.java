package siestageek.spring.mvc.utils;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("imgutil")
public class ImgUploadUtil {

    // 이미지 업로드 경로 설정
    private String uploadPath = "C:/Java/nginx-1.20.1/html/cdn/";
    private String thumbnailPath = "C:/Java/nginx-1.20.1/html/thumb/";


    // 갤러리에 이미지 첨부시 파일 존재 여부 확인
    public boolean checkGalleryFiles(MultipartFile[] img) {
        boolean isFiles = false;

        for(MultipartFile f : img) { // 첨부시 파일이름이 존재한다면
            if (!f.getOriginalFilename().isEmpty()) {
                isFiles = true;
                break;
            }
        }

        return isFiles;
    }

    public String ImageUpload(MultipartFile f, String uuid) {
        // uuid : 20210616111111
        // fname : abc.png
        // => 20210616111111_abc.png (x)
        // => abc20210616111111.png (o)
        String ofname = f.getOriginalFilename();
        //String nfname = makeUUID() + "_" + ofname;

        int pos = ofname.lastIndexOf(".");
        String nfname = ofname.substring(0, pos) + uuid + "." +
                       ofname.substring(pos+1); // 파일명 생성

        try {
            f.transferTo(new File(uploadPath + nfname)); // 이미지 저장
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ofname + "/" + (f.getSize()/1024); // 파일명과 파일크기를 리턴함
    }

    // 업로드한 이미지들 중 첫번째 이미지의 썸내일 생성
    public void imageCropResize(String fname, String id) {

        // 서버에 업로드된 파일이름 (썸내일 대상)
        String ofname = uploadPath + fname;
        // 업로드된 파일이름에서 확장자 부분 추출
        String imgtype = fname.substring(fname.lastIndexOf(".")+1);
        // 썸내일 이미지 이름 설정
        String tfname = thumbnailPath + "small_" + id + "_" + fname;

        try {
            // 원본이미지를 읽어서 메모리상에 이미지 객체(갠버스)로 만들어 둠
            BufferedImage image = ImageIO.read(new File(ofname));

            int imgwidth = Math.min(image.getHeight(), image.getWidth());
            int imgheight = imgwidth;

            // 지정한 위치를 기준으로 잘라냄
            BufferedImage scaledImg = Scalr.crop( image,
                    (image.getWidth() - imgwidth) / 2,
                    (image.getHeight() - imgheight) / 2,
                    imgwidth, imgheight, null );

            // 잘라낸 이미지를 220x220으로 재조정
            BufferedImage resizedImg = Scalr.resize(
                    scaledImg, 220, 220, null);

            // 재조정한 이미지를 실제경로에 저장함
            ImageIO.write(resizedImg, imgtype, new File(tfname));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // 겹치치 않는 파일명을 위해 유니크한 임의의 값 생성
    public String makeUUID() {
        String fmt = "yyyyMMddHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);

        return sdf.format(new Date());
    }

}
