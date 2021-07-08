package com.android.uniinfo;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class offUni {

    private static final String SAMPLE_JSON_RESPONSE = "\"India\":[{\"domains\":[\"davietjal.org\"],\"web_pages\":[\"http://www.davietjal.org/\"],\"name\":\"DAVInstituteofEngineering&Technology\",\"alpha_two_code\":\"IN\",\"state-province\":\"Punjab\",\"country\":\"India\"},{\"domains\":[\"lpu.in\"],\"web_pages\":[\"http://www.lpu.in/\"],\"name\":\"LovelyProfessionalUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"Punjab\",\"country\":\"India\"},{\"domains\":[\"somaiya.edu\"],\"web_pages\":[\"https://somaiya.edu/\"],\"name\":\"SomaiyaVidyavihar\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"ncuindia.edu\"],\"web_pages\":[\"http://www.ncuindia.edu/\"],\"name\":\"NorthCapUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"Haryana\",\"country\":\"India\"},{\"domains\":[\"ddu.ac.in\"],\"web_pages\":[\"http://www.ddu.ac.in/\"],\"name\":\"DharamsinhDesaiUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"Gujarat\",\"country\":\"India\"},{\"domains\":[\"ntruhs.ap.nic.in\"],\"web_pages\":[\"http://ntruhs.ap.nic.in/\"],\"name\":\"UniversityofHealthSciencesAndhraPradesh\",\"alpha_two_code\":\"IN\",\"state-province\":\"AndhraPradesh\",\"country\":\"India\"},{\"domains\":[\"aaidu.org\"],\"web_pages\":[\"http://www.aaidu.org/\"],\"name\":\"AllahabadAgriculturalInstitute,DeemedUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"aau.ac.in\"],\"web_pages\":[\"http://www.aau.ac.in/\"],\"name\":\"AssamAgriculturalUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"Assam\",\"country\":\"India\"},{\"domains\":[\"ahduni.edu.in\"],\"web_pages\":[\"http://www.ahduni.edu.in/\"],\"name\":\"AhmedabadUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"Gujarat\",\"country\":\"India\"},{\"domains\":[\"aiims.ac.in\"],\"web_pages\":[\"http://www.aiims.ac.in/\"],\"name\":\"AllIndiaInstituteofMedicalSciences\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"aisectuniversity.ac.in\"],\"web_pages\":[\"http://www.aisectuniversity.ac.in/\"],\"name\":\"AISECTUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"alagappauniversity.ac.in\"],\"web_pages\":[\"http://www.alagappauniversity.ac.in/\"],\"name\":\"AlagappaUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"TamilNadu\",\"country\":\"India\"},{\"domains\":[\"alldunivpio.org\"],\"web_pages\":[\"http://www.alldunivpio.org/\"],\"name\":\"AllahabadUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":\"UttarPradesh\",\"country\":\"India\"},{\"domains\":[\"altmeduniversity.com\"],\"web_pages\":[\"http://www.altmeduniversity.com/\"],\"name\":\"OpenInternationalUniversityforAlternativeMedicines\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"altmedworld.net\"],\"web_pages\":[\"http://www.altmedworld.net/\"],\"name\":\"IndianBoardofAlternativeMedicine\",\"alpha_two_code\":\"IN\",\"state-province\":\"WestBengal\",\"country\":\"India\"},{\"domains\":[\"amity.edu\"],\"web_pages\":[\"http://www.amity.edu/\"],\"name\":\"AmityUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"amrita.edu\"],\"web_pages\":[\"http://www.amrita.edu/\"],\"name\":\"AmritaVishwaVidyapeetham(DeemedUniversity)\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"amtuni.com\"],\"web_pages\":[\"http://www.amtuni.com/\"],\"name\":\"AmravatiUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"amu.ac.in\"],\"web_pages\":[\"http://www.amu.ac.in/\"],\"name\":\"AligarhMuslimUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"},{\"domains\":[\"andhrauniversity.info\"],\"web_pages\":[\"http://www.andhrauniversity.info/\"],\"name\":\"AndhraUniversity\",\"alpha_two_code\":\"IN\",\"state-province\":null,\"country\":\"India\"}]";


    private offUni(){

    }

    public static ArrayList<dUniversity> extracUniversity() {
        long mTimeInMilliseconds;

        ArrayList<dUniversity> universities = new ArrayList<>();
        try {

            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);

            for (int i=0;i<baseJsonResponse.length();i++){
                JSONObject uObject = baseJsonResponse.getJSONObject("India");
                String uniName = uObject.getString("name");

                dUniversity university =new dUniversity(uniName);
                universities.add(university);
            }

        } catch (JSONException e) {

        }
        return universities;
    }
}
