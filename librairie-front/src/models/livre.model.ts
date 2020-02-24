export class Livre {
  constructor(public auteur: string,
              public categorie: string,
              public dateParution : Date,
              public id : number,
              public isbn : string,
              public maisonEdition : any,
              public nom: string,
              public quantite: number,
              public resume: string) {
  }
}
