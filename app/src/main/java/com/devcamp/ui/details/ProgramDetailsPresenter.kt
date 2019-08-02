package com.devcamp.ui.details

class ProgramDetailsPresenter(private val view: ProgramDetailsView){
   fun onCreateView(){
       view.addProgramDetails()
   }
}

