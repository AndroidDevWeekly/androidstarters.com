package <%= appPackage %>.domain.services.networking;

import <%= appPackage %>.model.Comment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface RemoteCommentEndpoint {

    @POST("comments")
    Call<Comment> addComment(@Body Comment comment);
}
