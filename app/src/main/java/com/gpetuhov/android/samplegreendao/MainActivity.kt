package com.gpetuhov.android.samplegreendao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pawegio.kandroid.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var noteDao: NoteDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNoteDao()

        updateCounters()

        saveNoteButton.setOnClickListener { saveNote() }
    }

    private fun initNoteDao() {
        // Get DAO for notes
        noteDao = (application as SampleGreenDaoApp).daoSession.noteDao
    }

    private fun saveNote() {
        val text = editText.text.toString()

        if (text != "") {
            // Create new Note entity and insert it into database
            val note = Note()
            note.text = text
            noteDao?.insert(note)

            updateCounters()

            // Clear EditText
            editText.setText("")

            toast("Note saved")

        } else {
            toast("Note should not be empty")
        }
    }

    private fun updateCounters() {
        updateNotesCount()
        updateSpecialNotesCount()
    }

    private fun updateNotesCount() {
        // Query for all notes
        val count = noteDao?.loadAll()?.size ?: 0

        val text = "Total notes: $count"
        notesCount.text = text
    }

    private fun updateSpecialNotesCount() {
        // Query for notes which text equals to "Bob"
        val count = noteDao?.queryBuilder()
            ?.where(NoteDao.Properties.Text.eq("Bob"))
            ?.list()
            ?.size ?: 0

        val text = "Total Bob notes: $count"
        specialNotesCount.text = text
    }
}
