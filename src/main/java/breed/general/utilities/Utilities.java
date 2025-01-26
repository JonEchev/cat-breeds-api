package breed.general.utilities;

import breed.general.generateerrors.ControllerException;
import breed.general.generateerrors.ControllerMessages;
import breed.general.model.BusinessErrorType;
import breed.general.model.DataHeader;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static final String TYPE_ERROR = "E";
    public static final Integer CODE_1_SERVER_ERROR = -1;

    public static DataHeader generateResponseError(String key) {

        String msg = getValueMessage(key);
        JSONObject objectMsg = jsonStringToObject(msg);
        List<BusinessErrorType> errorTypeList = new ArrayList<>();

        BusinessErrorType errorType = BusinessErrorType.builder()
                .idError(objectMsg.getLong("id"))
                .descError(objectMsg.getString("desc"))
                .tipoError(TYPE_ERROR)
                .build();

        errorTypeList.add(errorType);

        return DataHeader.builder()
                .codRespuesta(CODE_1_SERVER_ERROR)
                .errores(errorTypeList)
                .build();

    }

    public static String getValueMessage(String key) {
        return ControllerMessages.messages.getString(key);
    }

    public static JSONObject jsonStringToObject(String jsonString) {

        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new ControllerException(generateResponseError("msg_error_procesamiento"));
        }

    }

}
