package space.septianrin.simpleonlinecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import space.septianrin.simpleonlinecalculator.databinding.ActivityMainBinding

interface MainInterface {
    interface View {
        fun showOverflowMenu(context: Context, view: android.view.View)
        fun showToast(context: Context, message: String?)
    }

    interface Presenter {
        fun onCreate(activity: AppCompatActivity, binding: ActivityMainBinding)
    }
}