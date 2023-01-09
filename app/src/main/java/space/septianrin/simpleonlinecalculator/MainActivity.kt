package space.septianrin.simpleonlinecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import io.reactivex.rxjava3.disposables.CompositeDisposable
import space.septianrin.simpleonlinecalculator.Constant.ADD
import space.septianrin.simpleonlinecalculator.Constant.DIVIDE
import space.septianrin.simpleonlinecalculator.Constant.MULTIPLY
import space.septianrin.simpleonlinecalculator.Constant.SPLITEQ
import space.septianrin.simpleonlinecalculator.Constant.SPLITNUM
import space.septianrin.simpleonlinecalculator.Constant.SUBSTRACT
import space.septianrin.simpleonlinecalculator.databinding.ActivityMainBinding
import space.septianrin.simpleonlinecalculator.networking.RetrofitBuilder

class MainActivity : AppCompatActivity(), MainInterface.View {
    private var presenter = MainPresenter(this)
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.onCreate(this,binding)
    }

    override fun showOverflowMenu(context: Context, view: View) {
        val menu = PopupMenu(context, view)

        menu.menu.apply {
            add(ADD).setOnMenuItemClickListener {
                binding.dropdownHello.text = ADD
                true
            }
            add(SUBSTRACT).setOnMenuItemClickListener {
                binding.dropdownHello.text = SUBSTRACT
                true
            }

            add(MULTIPLY).setOnMenuItemClickListener {
                binding.dropdownHello.text = MULTIPLY
                true
            }
            add(DIVIDE).setOnMenuItemClickListener {
                binding.dropdownHello.text = DIVIDE
                true
            }
            add(SPLITEQ).setOnMenuItemClickListener {
                binding.dropdownHello.text = SPLITEQ
                true
            }
            add(SPLITNUM).setOnMenuItemClickListener {
                binding.dropdownHello.text = SPLITNUM
                true
            }
        }
        menu.show()
    }

    override fun showToast(context: Context, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}