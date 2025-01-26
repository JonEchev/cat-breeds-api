package breed.catapi.service;

import breed.general.model.CatBreedDTO;
import breed.general.generateerrors.ControllerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatImageServiceImplTest {

    @InjectMocks
    private CatServiceImpl catImageServiceImpl;

    @Mock
    private RestTemplate restTemplate;

    private static final String URL = "https://api.thecatapi.com/v1/breeds";

    private CatBreedDTO catBreedDTO;
    private CatBreedDTO[] mockResponse;

    @BeforeEach
    void setUp() {

        ReflectionTestUtils.setField(catImageServiceImpl, "apiKeyValue", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP");
        ReflectionTestUtils.setField(catImageServiceImpl, "urlValue", "https://api.thecatapi.com/v1/breeds");

        catBreedDTO = new CatBreedDTO();
        catBreedDTO.setId("abys");
        catBreedDTO.setName("Abyssinian");
        catBreedDTO.setDescription("Description cat breed.");

        mockResponse = new CatBreedDTO[]{catBreedDTO};

    }

    @Test
    void getCatBreedsSuccessfulTest() {

        when(restTemplate.exchange(eq(URL), eq(HttpMethod.GET), any(HttpEntity.class), eq(CatBreedDTO[].class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        List<CatBreedDTO> result = catImageServiceImpl.getCatBreeds();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Abyssinian", result.get(0).getName());

    }

    @Test
    void getCatBreedsErrorTest() {

        when(restTemplate.exchange(eq(URL), eq(HttpMethod.GET), any(), eq(CatBreedDTO[].class)))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

        ControllerException exception = assertThrows(
                ControllerException.class, () -> catImageServiceImpl.getCatBreeds()
        );

        assertNull(exception.getMessage());

    }

    @Test
    void getCatBreedByIdTest() {

        String breedId = "abys";
        String urlWithId = URL + "/" + breedId;

        when(restTemplate.exchange(eq(urlWithId), eq(HttpMethod.GET), any(), eq(CatBreedDTO.class)))
                .thenReturn(new ResponseEntity<>(catBreedDTO, HttpStatus.OK));

        CatBreedDTO result = catImageServiceImpl.getCatBreedById(breedId);

        assertNotNull(result);
        assertEquals(breedId, result.getId());
        assertEquals("Abyssinian", result.getName());

    }

    @Test
    void getCatBreedsSearchDataTest() {

        String query = "abyssinian";
        String urlWithQuery = URL + "/search?q=" + query;

        when(restTemplate.exchange(eq(urlWithQuery), eq(HttpMethod.GET), any(HttpEntity.class), eq(CatBreedDTO[].class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        List<CatBreedDTO> result = catImageServiceImpl.getCatBreedsSearchData(query);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Abyssinian", result.get(0).getName());

    }

    @Test
    void getCatBreedsSearchDataErrorTest() {

        String query = "abyssinian";
        String urlWithQuery = URL + "/search?q=" + query;

        when(restTemplate.exchange(eq(urlWithQuery), eq(HttpMethod.GET), any(), eq(CatBreedDTO[].class)))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

        ControllerException exception = assertThrows(
                ControllerException.class, () -> catImageServiceImpl.getCatBreedsSearchData(query)
        );

        assertNull(exception.getMessage());

    }

}