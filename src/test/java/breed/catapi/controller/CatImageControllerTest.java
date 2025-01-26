package breed.catapi.controller;

import breed.catapi.service.CatService;
import breed.general.generateerrors.ControllerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatImageControllerTest {

    @InjectMocks
    private CatController catImageController;

    @Mock
    private CatService catImageService;

    @Test
    void getCatBreedsTest() {

        ResponseEntity<?> result = catImageController.getCatBreeds();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    void getCatBreedsErrorTest() {

        when(catImageService.getCatBreeds()).thenThrow(new NoSuchElementException("Elemento no encontrado"));

        ControllerException controllerExceptionThrown = assertThrows(ControllerException.class, () -> {
            catImageController.getCatBreeds();
        });

        Assertions.assertNotNull(controllerExceptionThrown);

    }

    @Test
    void getCatBreedByIdTest() {

        ResponseEntity<?> result = catImageController.getCatBreedById("abys");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    void getCatBreedByIdErrorTest() {

        when(catImageService.getCatBreedById(anyString())).thenThrow(new NoSuchElementException("Elemento no encontrado"));

        ControllerException controllerExceptionThrown = assertThrows(ControllerException.class, () -> {
            catImageController.getCatBreedById("abys");
        });

        Assertions.assertNotNull(controllerExceptionThrown);

    }

    @Test
    void getCatBreedsSearchDataTest() {

        ResponseEntity<?> result = catImageController.getCatBreedsSearchData("bengal");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    void getCatBreedsSearchDataErrorTest() {

        when(catImageService.getCatBreedsSearchData(anyString())).thenThrow(new NoSuchElementException("Elemento no encontrado"));

        ControllerException controllerExceptionThrown = assertThrows(ControllerException.class, () -> {
            catImageController.getCatBreedsSearchData("bengal");
        });

        Assertions.assertNotNull(controllerExceptionThrown);

    }

}