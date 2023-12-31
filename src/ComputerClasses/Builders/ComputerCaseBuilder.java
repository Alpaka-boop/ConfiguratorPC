package ComputerClasses.Builders;

import ComputerClasses.Computer;
import ComputerClasses.ComputerCase;
import ComputerClasses.FormFactor;
import ComputerClasses.Size;

public class ComputerCaseBuilder {
    private Size maxVideoCardSize;
    private FormFactor formFactor;

    public ComputerCaseBuilder() {}

    public ComputerCaseBuilder(ComputerCase computerCase) {
        this.formFactor = computerCase.getFormFactor();
        this.maxVideoCardSize = computerCase.getMaxVideoCardSize();
    }

    public ComputerCaseBuilder setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    public ComputerCaseBuilder setMaxVideoCardSize(Size maxVideoCardSize) {
        this.maxVideoCardSize = maxVideoCardSize;
        return this;
    }

    public ComputerCase build() {
        return new ComputerCase(formFactor, maxVideoCardSize);
    }
}
