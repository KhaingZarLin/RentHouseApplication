package com.example.renthouseapplication.network.dataagents;

import android.os.AsyncTask;

import com.example.renthouseapplication.network.response.GetRentResponse;
import com.example.renthouseapplication.utils.RentConstants;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUrlConnectionDataAgentImpl implements RentDataAgent{

    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl(){

    }

    public static HttpUrlConnectionDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getRent(String accessToken, GetRentFromNetworkDelegate delegate) {
        new GetEventsTask(RentConstants.DUAMY_ACCESS_TOKEN,delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetRentResponse> {

        private String accessToken;
        private GetRentFromNetworkDelegate newsResponseDelegate;

        public GetEventsTask(String duamyAccessToken,GetRentFromNetworkDelegate delegate) {
            this.accessToken=duamyAccessToken;
            this.newsResponseDelegate = delegate;
        }


        @Override
        protected GetRentResponse doInBackground(Void... voids) {

            URL url;
            BufferedReader bufferedReader = null;
            StringBuilder stringBuilder;

            try {
                url = new URL(RentConstants.BASE_URL + RentConstants.GET_EVENTS);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");

                //give it 15seconds to respond
                connection.setReadTimeout(15 * 1000);

                connection.setDoInput(true);
                connection.setDoOutput(true);

                //put the request parameter into NameValuePair list.
                /*List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(EventsConstants.PARAM_ACCESS_TOKEN, accessToken));

                //write the parameter into NameValuePair list into connection object.
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();*/

                connection.connect();

                //read the output from the server
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }

                String responseString = stringBuilder.toString();

                GetRentResponse response = new Gson().fromJson(responseString, GetRentResponse.class);

                return response;

            } catch (Exception e){

            }finally {
                //close the reader; this can throw an exception too, so
                //wrap it in another try/catch block.
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(GetRentResponse getRentResponse) {
            super.onPostExecute(getRentResponse);

            if(getRentResponse != null){
                if (getRentResponse.isResponseOk())
                {
                    newsResponseDelegate.onSuccess(getRentResponse.getRentVOList());
                }
                else
                {
                    newsResponseDelegate.onFailure(getRentResponse.getMessage());
                }
            }
            else
            {
                newsResponseDelegate.onFailure(RentConstants.EM_NULL_EVENT_RESPONSE);
            }
        }

        /*private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            for(NameValuePair pair : params){
                if (first){
                    first = false;
                }else {
                    result.append("&");
                }

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }
            return result.toString();
        }*/


    }

}
