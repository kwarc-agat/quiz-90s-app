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

class FragmentQuestion5 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question5, container, false)
        val img_next = view.findViewById<ImageView>(R.id.id_img_next5)
        img_next.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion5_to_fragmentResults) }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelQuiz::class.java)
        val answer_a = view.findViewById<ImageView>(R.id.id_img_5_a)
        val answer_b = view.findViewById<ImageView>(R.id.id_img_5_b)
        val answer_c = view.findViewById<ImageView>(R.id.id_img_5_c)

        answer_a.setOnClickListener{
            answer_a.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_red)
            answer_c.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_orange)
        }
        answer_b.setOnClickListener{
            answer_b.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_red)
            answer_c.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_orange)
        }
        answer_c.setOnClickListener{
            answer_c.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_orange)
            viewModel.score += 1
        }

    }
}