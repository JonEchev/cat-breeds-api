package breed.catapi.controller;

import breed.general.generateerrors.ControllerException;
import breed.general.utilities.Utilities;
import breed.general.model.CatBreedDTO;
import breed.catapi.service.CatService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cats")
public class CatController {

    @Autowired
    CatService catImageService;

    Logger log = LogManager.getLogger(CatController.class);

    @GetMapping("/consultAll")
    public ResponseEntity<List<CatBreedDTO>> getCatBreeds() {

        try {
            return ResponseEntity.ok(catImageService.getCatBreeds());
        } catch (Exception ex) {
            log.warn("***MS TheCatAPI - se presento un inconveniente consultado las razas de gatos, el problema es: {} ", ex.getMessage());
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_cat"));
        }

    }

    @GetMapping("/consult/{catBreedId}")
    public ResponseEntity<CatBreedDTO> getCatBreedById(@PathVariable String catBreedId) {

        try {
            return ResponseEntity.ok(catImageService.getCatBreedById(catBreedId));
        } catch (Exception ex) {
            log.warn("***MS TheCatAPI - se presento un problema consultando la informacion del id, el error es: {} ", ex.getMessage());
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_datos_breed_cat"));
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<CatBreedDTO>> getCatBreedsSearchData(@RequestParam String catQuery) {

        try {
            return ResponseEntity.ok(catImageService.getCatBreedsSearchData(catQuery));
        } catch (Exception ex) {
            log.error("***MS TheCatAPI - se presento un error consultando la raza del gato, el problema es: {} ", ex.getMessage());
            throw new ControllerException(Utilities.generateResponseError("msg_error_consultar_data_cat"));
        }

    }

}