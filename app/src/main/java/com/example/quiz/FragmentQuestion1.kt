package com.example.quiz

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class FragmentQuestion1 : Fragment() {
    lateinit var musicPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        musicPlayer = MediaPlayer.create(activity, R.raw.song)
        musicPlayer.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question1, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelQuiz::class.java)
        val img_next = view.findViewById<ImageView>(R.id.id_img_next1)
        val btn_play = view.findViewById<ImageButton>(R.id.id_imgbtn_q1)
        val answer_a = view.findViewById<Button>(R.id.id_btn_1_a)
        val answer_b = view.findViewById<Button>(R.id.id_btn_1_b)
        val answer_c = view.findViewById<Button>(R.id.id_btn_1_c)

        img_next.setOnClickListener {

            musicPlayer.stop()
            musicPlayer.release()
            Navigation.findNavController(view).navigate(R.id.action_question1_to_question2)
        }
        btn_play.setOnClickListener{ musicPlayer.start() }

        answer_a.setOnClickListener{
            answer_a.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_c.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }
        answer_b.setOnClickListener{
            answer_b.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_c.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }
        answer_c.setOnClickListener{
            answer_c.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
            viewModel.score += 1
        }


    }

    override fun onDetach() {
        super.onDetach()
        musicPlayer.stop()
        musicPlayer.release()
    }
}