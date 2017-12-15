import { OnInit, Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineNumberConfig } from "../types/inline-configs";
export declare class InputNumberComponent extends InputBase implements OnInit {
    constructor(injector: Injector);
    config: InlineNumberConfig;
}
