package breed.catapi.service;

import breed.general.model.CatBreedDTO;

import java.util.List;

public interface CatService {

    List<CatBreedDTO> getCatBreeds();

    CatBreedDTO getCatBreedById(String breedId);

    List<CatBreedDTO> getCatBreedsSearchData(String query);

}
