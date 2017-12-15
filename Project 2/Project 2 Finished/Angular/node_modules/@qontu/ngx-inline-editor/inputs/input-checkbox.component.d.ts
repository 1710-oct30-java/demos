import { Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineConfig } from "../types/inline-configs";
export declare class InputCheckboxComponent extends InputBase {
    constructor(injector: Injector);
    config: InlineConfig;
    showText(): string;
}
