package hxz.www.commonbase.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class KLGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeToken<T> typeToken;

    KLGsonResponseBodyConverter(Gson gson, TypeToken<T> typeToken) {
        this.gson = gson;
        this.typeToken = typeToken;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            JSONObject jsonObject = new JSONObject(value.string());
            JSONObject jsonData = (JSONObject) jsonObject.opt("data");
            if (jsonData == null || jsonData.equals("")) {
                jsonObject.remove("data");
            }
            return (T) gson.fromJson(jsonObject.toString(), typeToken.getRawType());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            value.close();
        }
    }
}
