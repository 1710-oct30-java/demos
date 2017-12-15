import { OnInit, Injector } from "@angular/core";
import { InputBase } from "./input-base";
import { InlineSelectConfig } from "../types/inline-configs";
import { SelectOptionWithChildren, SelectOption } from "../types/select-options.interface";
import { OnUpdateConfig } from "../types/lifecycles.interface";
export declare class InputSelectComponent extends InputBase implements OnInit, OnUpdateConfig {
    constructor(injector: Injector);
    config: InlineSelectConfig;
    onUpdateConfig(config: InlineSelectConfig): void;
    showText(): string;
    protected getOptionSelected(currentValue: any, keyOfValue: string, options: (SelectOption | SelectOptionWithChildren)[]): SelectOption | undefined;
    protected isEmpty(value: any): boolean;
    protected isAnOptionWithChildren(options: SelectOptionWithChildren): options is SelectOptionWithChildren;
}
