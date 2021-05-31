package id.ac.unhas.cuaca.terkini

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.unhas.cuaca.R
import id.ac.unhas.cuaca.model.CuacaTerkini
import id.ac.unhas.cuaca.model.network.CurrentApiService
import kotlinx.android.synthetic.main.fragment_cuaca_terkini_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class fragmentCuacaTerkini : Fragment() {

    companion object {
        fun newInstance() = fragmentCuacaTerkini()
    }

    private lateinit var viewModel: FragmentCuacaTerkiniViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cuaca_terkini_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentCuacaTerkiniViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = CurrentApiService()

        GlobalScope.launch(Dispatchers.Main) {
            val CuacaTerkini = apiService.getCurrentWeather("Indonesia").await()
            textView.text = CuacaTerkini.toString()
        }

    }

}