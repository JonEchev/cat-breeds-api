package breed.catapi.service;

import breed.general.generateerrors.ControllerException;
import breed.general.utilities.Utilities;
import breed.general.model.CatBreedDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CatServiceImpl implements CatService {

    Logger log = LogManager.getLogger(CatServiceImpl.class);

    private final RestTemplate restTemplate;

    @Value("${services.apikey}")
    private String apiKeyValue;
    @Value("${services.url}")
    private String urlValue;

    public CatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-api-key", apiKeyValue);
        return httpHeaders;
    }

    @Override
    public List<CatBreedDTO> getCatBreeds() {

        HttpEntity<String> entity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<CatBreedDTO[]> response = restTemplate.exchange(urlValue, HttpMethod.GET, entity, CatBreedDTO[].class);

        log.info("***MS TheCatAPI - el status de la consulta en detalle de las razas de gatos es: {}", response.getStatusCode());

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("***MS TheCatAPI - se obtuvo correctamente la lista en detalle de razas de gatos.");
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        } else {
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_cat"));
        }

    }

    @Override
    public CatBreedDTO getCatBreedById(String catBreedId) {

        String url = urlValue + "/" + catBreedId;
        HttpEntity<String> entity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<CatBreedDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, CatBreedDTO.class);

        log.info("***MS TheCatAPI - el status de la consulta de los datos del id del gato es: {}", response.getStatusCode());

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("***MS TheCatAPI - se obtuvo correctamente los datos del id del gato: {}.", catBreedId);
            return response.getBody();
        } else {
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_datos_breed_cat"));
        }

    }

    @Override
    public List<CatBreedDTO> getCatBreedsSearchData(String query) {

        String url = urlValue + "/search?q=" + query;
        HttpEntity<String> entity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<CatBreedDTO[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, CatBreedDTO[].class);

        log.info("***MS TheCatAPI - el status de la consulta es: {}", response.getStatusCode());

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("***MS TheCatAPI - se obtuvo correctamente los datos de la consulta.");
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        } else {
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_data_cat"));
        }

    }

}