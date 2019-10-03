package com.softcodeinfotech.dog.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.softcodeinfotech.dog.R
import com.softcodeinfotech.dog.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        dogList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
        refreshLayout.setOnRefreshListener {
            dogList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.dogs.observe(this, Observer {
            it?.let {
                dogList.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(it)
            }

            viewModel.dogsLoadError.observe(this, Observer { isError ->
                isError?.let {
                    listError.visibility = if (it) View.VISIBLE else View.GONE
                }
            })

            viewModel.loading.observe(this, Observer { isLoading ->
                isLoading?.let {
                    loadingView.visibility = if (it) View.VISIBLE else View.GONE
                    if (it) {
                        listError.visibility = View.GONE
                        dogList.visibility = View.GONE
                    }
                }

            })
        })
    }


}


