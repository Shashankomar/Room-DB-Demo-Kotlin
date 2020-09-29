import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class CountryListModel(
    @Expose
    @SerializedName("name")
    val name: String,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("subregion")
    val subregion: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("borders")
    val borders: List<String>,
    @SerializedName("languages")
    val languages: List<Languages>,
    @SerializedName("flag")
    val flag: String
) : Parcelable