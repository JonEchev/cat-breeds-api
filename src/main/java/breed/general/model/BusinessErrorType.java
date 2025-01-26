package breed.general.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessErrorType {

    protected Long idError;
    protected String descError;
    protected String tipoError;

}