package com.example.quiz

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class FragmentQuestion4 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question4, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModelQuiz::class.java)
        val answer_a = view.findViewById<Button>(R.id.id_btn_4_a)
        val answer_b = view.findViewById<Button>(R.id.id_btn_4_b)
        val answer_c = view.findViewById<Button>(R.id.id_btn_4_c)
        val img_next = view.findViewById<ImageView>(R.id.id_img_next4)
        val videoView = view.findViewById<VideoView>(R.id.id_video)
        val mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(Uri.parse("android.resource://" + context?.getPackageName() + "/" +
                R.raw.video));
        videoView.start()

        answer_a.setOnClickListener{
            answer_a.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_b.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }
        answer_b.setOnClickListener{
            answer_b.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
            viewModel.score += 1
        }
        answer_c.setOnClickListener{
            answer_c.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.burgund))
            answer_b.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange))
        }

        img_next.setOnClickListener {
            videoView.stopPlayback()
            Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion4_to_fragmentQuestion5)
        }

    }
}