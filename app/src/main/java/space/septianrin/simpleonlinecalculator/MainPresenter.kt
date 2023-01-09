package space.septianrin.simpleonlinecalculator

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONArray
import org.json.JSONObject
import space.septianrin.simpleonlinecalculator.Constant.ADD
import space.septianrin.simpleonlinecalculator.Constant.DIVIDE
import space.septianrin.simpleonlinecalculator.Constant.MULTIPLY
import space.septianrin.simpleonlinecalculator.Constant.SPLITEQ
import space.septianrin.simpleonlinecalculator.Constant.SPLITNUM
import space.septianrin.simpleonlinecalculator.Constant.SUBSTRACT
import space.septianrin.simpleonlinecalculator.databinding.ActivityMainBinding
import space.septianrin.simpleonlinecalculator.models.BackendResponse
import space.septianrin.simpleonlinecalculator.networking.RetrofitBuilder

class MainPresenter(
    private val view: MainInterface.View? = null
) : MainInterface.Presenter {
    private val disposable = CompositeDisposable()
    private val apiUrl = RetrofitBuilder.apiUrl


    override fun onCreate(activity: AppCompatActivity, binding: ActivityMainBinding) {
        listener(binding, activity)
    }

    private fun listener(binding: ActivityMainBinding, activity: AppCompatActivity) {
        with(binding) {
            btnHello.setOnClickListener {
                if (evHello.text.isNotEmpty()) {
                    setOperationResult(evHello.text.toString(), binding, activity)

                } else {
                    view?.showOverflowMenu(activity.applicationContext, btnHello)
                }
            }
            clOperation.setOnClickListener {
                view?.showOverflowMenu(activity.applicationContext, dropdownHello)
            }
        }
    }

    private fun setOperationResult(
        userInput: String,
        binding: ActivityMainBinding,
        activity: AppCompatActivity
    ) {
        val inputJson = generateUserInput(userInput, activity)
        when (binding.dropdownHello.text) {
            ADD -> {
                requestAdd(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })
            }
            SUBSTRACT -> {
                requestSubstract(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })
            }
            MULTIPLY -> {
                requestMultiply(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })
            }
            DIVIDE -> {
                requestDivide(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })

            }
            SPLITEQ -> {
                requestSpliteq(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })

            }
            SPLITNUM -> {
                requestSplitnum(
                    inputJson,
                    {
                        if(it.status == 200){
                            binding.tvHello.text = it.data
                        } else {
                            view?.showToast(activity.applicationContext, it.message)
                        }
                    }, {
                        view?.showToast(activity.applicationContext, it.message)
                    })

            }

        }

    }

    private fun generateUserInput(userInput: String,activity: AppCompatActivity): JsonObject {
        var listInt : List<Int> = listOf()
        try {
            listInt =  userInput.split(",").map { it.toInt() }
        } catch (e: Exception) {
            view?.showToast(activity.applicationContext, "You must input parameter as the format (E.g 10,10,10)")
        }
        return generateJson(listInt)
    }

    private fun generateJson(listInt: List<Int>): JsonObject {
        val jsonArray = JSONArray(listInt)
        val json = JSONObject()
        json.put("numberList", jsonArray)
        return JsonParser.parseString(json.toString()).asJsonObject
    }

    private fun requestAdd(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.add(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }

    private fun requestSubstract(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.substract(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }

    private fun requestMultiply(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.multiply(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }

    private fun requestDivide(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.divide(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }
    private fun requestSpliteq(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.spliteq(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }
    private fun requestSplitnum(
        frontendRequest: JsonObject,
        onSuccess: (BackendResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiUrl.splitnum(frontendRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onError)
            .let(disposable::add)
    }
}