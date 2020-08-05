package com.module.dataAccesser;

import com.module.dataAccesser.pojo.VPortPlate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class PlateRestClientUtil {

    public void getArticleByIdDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/port/plate/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<VPortPlate> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, VPortPlate.class, 110);
        VPortPlate vPortPlate = responseEntity.getBody();
        System.out.println("plateId:"+vPortPlate.getPlateId()+", plateNo:"+vPortPlate.getPlateNo()
                +", ctime:"+vPortPlate.getCtime() + ", photoId:" + vPortPlate.getPhotos().get(0).getPhotoId());
    }

}
