import com.google.gson.annotations.SerializedName

data class Form (
	@SerializedName("fields") val fields : List<Field>
)