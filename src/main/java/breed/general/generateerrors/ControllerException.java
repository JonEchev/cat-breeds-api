package breed.general.generateerrors;

import breed.general.model.DataHeader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControllerException extends RuntimeException{
    protected DataHeader responseError;
}