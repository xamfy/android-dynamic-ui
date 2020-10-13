import com.google.gson.annotations.SerializedName

data class Field (
	@SerializedName("id") val id : Int,
	@SerializedName("ViewType") val viewType : String,
	@SerializedName("text") val text : String,
	@SerializedName("hintText") val hintText : String
)