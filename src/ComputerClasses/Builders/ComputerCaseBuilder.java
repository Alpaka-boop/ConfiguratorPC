package ComputerClasses.Builders;

import ComputerClasses.ComputerCase;
import ComputerClasses.FormFactor;
import ComputerClasses.Size;

public class ComputerCaseBuilder {
    private Size maxVideoCardSize;
    private FormFactor formFactor;

    public ComputerCaseBuilder addFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    public ComputerCaseBuilder addMaxVideoCardSize(Size maxVideoCardSize) {
        this.maxVideoCardSize = maxVideoCardSize;
        return this;
    }

    public ComputerCase build() {
        return new ComputerCase(formFactor, maxVideoCardSize);
    }
}
