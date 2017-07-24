package com.software.digitals.posterwizard.imgurmodel;

import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mitch on 7/23/2017.
 */

public interface ImgurModel {

    String server = "https://api.imgur.com";


    /****************************************
     * Upload
     * Image upload API
     */

    /**
     * @param auth        #Type of authorization for upload
     * @param title       #Title of image
     * @param description #Description of image
     * @param albumId     #ID for album (if the user is adding this image to an album)
     * @param username    username for upload
     * @param file        image
     * @param cb          Callback used for success/failures
     */
    @POST("/3/image")
    void postImage(
            @Header("Authorization") String auth,
            @Query("title") String title,
            @Query("description") String description,
            @Query("album") String albumId,
            @Query("account_url") String username,
            @Body RequestBody file,
            Callback<ImageResponse> cb
    );
}
