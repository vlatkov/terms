import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, Resolve } from '@angular/router';
import { Subject } from 'rxjs/Rx';

/**
 * Load partial translation JSON files on demand.
 * Example: login.routing.module.ts
 */
@Injectable()
export class TransResolver implements Resolve<boolean> {

  static readonly DATA_TRANS = 'translation'; // e.g. data: {translation: 'filename'}
  private langSubject = new Subject<string>();

  constructor(
    private http: HttpClient,
    private trans: TranslateService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {

    const partName = route.data[TransResolver.DATA_TRANS];
    if (!partName) {
      console.warn('TransResolver will not load translation file. No file name specifed.');
      return Observable.of(true);
    } else {
      return this.getPart(partName, this.trans.currentLang).map(part => {
        this.trans.setTranslation(this.trans.currentLang, part, true);
        this.trans.onLangChange.subscribe((param: LangChangeEvent) => {
          this.addPart(partName);
        });
        return true;
      });
    }
  }

  private addPart(partName: string) {
    this.getPart(partName, this.trans.currentLang).subscribe(part => {
      this.trans.setTranslation(this.trans.currentLang, part, true);
      this.langSubject.next(this.trans.currentLang);
    });
  }

  /**
   * Get partial translation file.
   * @param partName Part name.
   * @param lang Language code.
   */
  private getPart(partName: string, lang: string): Observable<any> {
    const url = `/assets/i18n/${lang}/${partName}.json`;
    return this.http.get(url).catch(this.handleError);
  }

  /**
   * Handle error.
   * @param error Error response.
   */
  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
      return Observable.throw(errMsg);
    }
  }

  get langState(): Observable<string> {
    return this.langSubject.asObservable();
  }
}

