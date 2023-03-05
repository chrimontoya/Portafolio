import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

const materialModules: any[] = [
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
];

@NgModule({
    imports: [
      CommonModule,
      ...materialModules
    ],
    exports: [
      ...materialModules
    ],
  })

export class MaterialModule { }  