import {Component, OnInit}      from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms"
import {LibrairieService}       from "../../service/librairie.service"
import {Search}                 from "../../models/search.model"

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  searchForm: FormGroup

  constructor(private formBuilder: FormBuilder, private librairieService: LibrairieService) {
  }

  ngOnInit() {
    this.initForm()
  }

  private initForm() {
    this.searchForm = this.formBuilder.group({
      nom: [''],
      auteur: [''],
      categorie: [''],
    })
  }

  Submit() {
    console.log("submit du formulaire")
    let form   = this.searchForm.value
    let search = new Search(form['nom'], form['auteur'], form['categorie'])
    this.librairieService.findByFields(search).subscribe((response) => {
      console.log(response)
    }, error => {
      console.log(error)
    })
  }
}
