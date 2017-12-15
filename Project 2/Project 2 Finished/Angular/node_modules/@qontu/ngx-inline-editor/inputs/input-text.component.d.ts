import { OnInit, Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineTextConfig } from "../types/inline-configs";
export declare class InputTextComponent extends InputBase implements OnInit {
    constructor(injector: Injector);
    config: InlineTextConfig;
}
