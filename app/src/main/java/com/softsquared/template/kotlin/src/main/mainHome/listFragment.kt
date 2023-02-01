package com.softsquared.template.kotlin.src.main.mainHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [listFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class listFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val dataList : ArrayList<MainData> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_list,container,false)
        dataList.add(MainData("숩", "위치 비밀",10,"밥 먹으실 분 있나요?"))
        dataList.add(MainData("밤비", "광진구 자양동",11,"밥 먹으실 분 있나요?"))
        dataList.add(MainData("우니", "성북구 장위동",12,"밥 먹으실 분 있나요?"))
        dataList.add(MainData("라나", "노원구 하계동",10,"밥 먹으실 분 있나요?"))
        dataList.add(MainData("차라나", "분당구 정자동",9,"밥 먹으실 분 있나요?"))
        recyclerView = rootView.findViewById(R.id.list_recyclerView!!)as RecyclerView
        recyclerView.layoutManager =LinearLayoutManager(requireContext())
        recyclerView.adapter=ListAdapter(dataList)
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment listFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            listFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}