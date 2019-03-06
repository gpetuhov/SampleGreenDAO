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

            // Clear EditText
            editText.setText("")

            toast("Note saved")

        } else {
            toast("Note should not be empty")
        }
    }
}
