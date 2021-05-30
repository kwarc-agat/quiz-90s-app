package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class FragmentQuestion3 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question3, container, false)
        val img_next = view.findViewById<ImageView>(R.id.id_img_next3)
        img_next.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_question3_to_fragmentQuestion4) }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelQuiz::class.java)
        val answer_a = view.findViewById<Button>(R.id.id_btn_3_a)
        val answer_b = view.findViewById<Button>(R.id.id_btn_3_b)
        val answer_c = view.findViewById<Button>(R.id.id_btn_3_c)

        answer_a.setOnClickListener{
            answer_a.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
            viewModel.score += 1
        }
        answer_b.setOnClickListener{
            answer_b.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_a.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }
        answer_c.setOnClickListener{
            answer_c.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_a.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }
    }
}