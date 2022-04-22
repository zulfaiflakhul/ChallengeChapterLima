package zulfa.binar.chapterlima.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import zulfa.binar.challengechapterlima.model.popular.GetPopularFilm
import zulfa.binar.challengechapterlima.network.ApiClient

class viewModelFilm : ViewModel() {

    lateinit var liveDataFilm : MutableLiveData<List<GetPopularFilm>?>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getLiveFilmObserver() : MutableLiveData<List<GetPopularFilm>?> {
        return liveDataFilm
    }

    fun makeApiFIlm(){
        ApiClient.instance.getPopularMovie()
            .enqueue(object : retrofit2.Callback<List<GetPopularFilm>>{

                override fun onResponse(
                    call: Call<List<GetPopularFilm>>,
                    response: Response<List<GetPopularFilm>>
                ) {
                    if (response.isSuccessful) {
                        liveDataFilm.postValue(response.body())
                    } else {
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetPopularFilm>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}