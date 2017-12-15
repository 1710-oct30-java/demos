import { OnInit, Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineConfig } from "../types/inline-configs";
export declare class InputDateComponent extends InputBase implements OnInit {
    constructor(injector: Injector);
    config: InlineConfig;
}
