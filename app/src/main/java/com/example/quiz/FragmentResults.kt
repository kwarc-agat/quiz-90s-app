package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation


class FragmentResults : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelQuiz::class.java)
        val btn_retry = view.findViewById<Button>(R.id.id_btn_retry)
        val btn_quit = view.findViewById<Button>(R.id.id_btn_quit)
        val tv_result = view.findViewById<TextView>(R.id.id_tv_result)

        val result_text = viewModel.score.toString() + "/" + viewModel.max_score.toString()

        tv_result.text = result_text

        btn_retry.setOnClickListener {
            viewModel.score = 0
            Navigation.findNavController(view).navigate(R.id.action_fragmentResults_to_question1)
        }
        btn_quit.setOnClickListener {
            val intent = Intent(activity, ActivityMain::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("LOGOUT", true)
            startActivity(intent)

            activity?.finish()
        }

    }
}