package com.devcamp.ui.details

import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity(), ProgramDetailsView{
    override fun addProgramDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//    private lateinit var presenter: ProgramDetailsPresenter
//    private lateinit var toolbar : Toolbar
//    private lateinit var thumb : ImageView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_details)
//
//        val extras = intent.extras
//        val programName = extras.getString(PROGRAM_NAME)
//
//        toolbar = findViewById(R.id.toolbar)
//        toolbar.title = programName
//        setSupportActionBar(toolbar)
//
//        thumb = findViewById(R.id.thumb)
//
//        presenter = ProgramDetailsPresenterBuilder.create(this)
//
//        if(supportActionBar != null) run {
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//            toolbar.setNavigationOnClickListener { finish() }
//        }
//
//        presenter.onCreateView()
//    }
//
//    override fun addProgramDetails() {
//        val extras = intent.extras
//      //  val programThumb = extras.getString(PROGRAM_THUMB)
//
//        ImageLoader.loadFitCenter(this,programThumb, R.drawable.mosaic_pattern,thumb)
//    }
//
//    companion object {
//        val PROGRAM_NAME = "ProgramName"
//    }
}
