package com.thorin.apps.asmal.ui.asisten.catatamal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.ActivityCatatAmalBinding
import com.thorin.apps.asmal.databinding.ActivityMainBinding
import com.thorin.apps.asmal.ui.asisten.catatamal.db.MappingHelper
import com.thorin.apps.asmal.ui.asisten.catatamal.db.NoteHelper
import com.thorin.apps.asmal.ui.asisten.catatamal.entitiy.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CatatAmalActivity : AppCompatActivity() {
    private lateinit var adapter: NoteAdapter
    private lateinit var noteHelper: NoteHelper
    private lateinit var binding: ActivityCatatAmalBinding

    companion object {
        private const val EXTRA_STATE = "EXTRA_STATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catat_amal)
        binding = ActivityCatatAmalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Catatan Amal"

        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.setHasFixedSize(true)
        adapter = NoteAdapter(this)
        binding.rvNotes.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@CatatAmalActivity, NoteAddUpdateActivity::class.java)
            startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_ADD)
        }

        noteHelper = NoteHelper.getInstance(applicationContext)
        noteHelper.open()

        if (savedInstanceState == null) {
            loadNotesAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<Note>(EXTRA_STATE)
            if (list != null) {
                adapter.listNotes = list
            }
        }
    }

    private fun loadNotesAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressbar.visibility = View.VISIBLE
            val deferredNotes = async(Dispatchers.IO) {
                val cursor = noteHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }
            binding.progressbar.visibility = View.INVISIBLE
            val notes = deferredNotes.await()
            if (notes.size > 0) {
                adapter.listNotes = notes
            } else {
                adapter.listNotes = ArrayList()
                showSnackbarMessage("Tidak ada data saat ini")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, adapter.listNotes)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            when (requestCode) {
                NoteAddUpdateActivity.REQUEST_ADD -> if (resultCode == NoteAddUpdateActivity.RESULT_ADD) {
                    val note = data.getParcelableExtra<Note>(NoteAddUpdateActivity.EXTRA_NOTE) as Note

                    adapter.addItem(note)
                    binding.rvNotes.smoothScrollToPosition(adapter.itemCount - 1)

                    showSnackbarMessage("Satu item berhasil ditambahkan")
                }
                NoteAddUpdateActivity.REQUEST_UPDATE ->
                    when (resultCode) {

                        NoteAddUpdateActivity.RESULT_UPDATE -> {

                            val note = data.getParcelableExtra<Note>(NoteAddUpdateActivity.EXTRA_NOTE) as Note
                            val position = data.getIntExtra(NoteAddUpdateActivity.EXTRA_POSITION, 0)

                            adapter.updateItem(position, note)
                            binding.rvNotes.smoothScrollToPosition(position)

                            showSnackbarMessage("Satu item berhasil diubah")
                        }

                        NoteAddUpdateActivity.RESULT_DELETE -> {
                            val position = data.getIntExtra(NoteAddUpdateActivity.EXTRA_POSITION, 0)

                            adapter.removeItem(position)

                            showSnackbarMessage("Satu item berhasil dihapus")
                        }
                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        noteHelper.close()
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding.rvNotes, message, Snackbar.LENGTH_SHORT).show()
    }
}