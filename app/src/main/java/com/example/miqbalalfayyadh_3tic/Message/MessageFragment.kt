package com.example.miqbalalfayyadh_3tic.Message

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.example.miqbalalfayyadh_3tic.R
import com.example.miqbalalfayyadh_3tic.databinding.FragmentHomeBinding
import com.example.miqbalalfayyadh_3tic.databinding.FragmentMessageBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.NonDisposableHandle.parent

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    //data nya
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/bottts/png?seed=Alya&size=128"),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/bottts/png?seed=Budi&size=128"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/bottts/png?seed=Citra&size=128"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/bottts/png?seed=Dika&size=128"),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/bottts/png?seed=Eka&size=128"),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/bottts/png?seed=Fajar&size=128"),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/bottts/png?seed=Gita&size=128"),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/bottts/png?seed=Hana&size=128"),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/bottts/png?seed=Irfan&size=128"),
        MessageModel("Joko", "Sampai jumpa besok", "https://api.dicebear.com/7.x/bottts/png?seed=Joko&size=128")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}