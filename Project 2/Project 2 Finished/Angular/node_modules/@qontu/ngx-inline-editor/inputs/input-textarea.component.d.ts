import { OnInit, Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineTextareaConfig } from "../types/inline-configs";
export declare class InputTextareaComponent extends InputBase implements OnInit {
    constructor(injector: Injector);
    config: InlineTextareaConfig;
}
