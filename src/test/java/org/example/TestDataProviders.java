package org.example;

import org.testng.annotations.DataProvider;

public class TestDataProviders {
    @DataProvider(name = "contactFormData")
    public Object[][] getContactFormData() {
        return new Object[][]{
                {
                        "Carl",
                        "a@vogf.com",
                        "55292500611",
                        "I want my order wrapped as a gift"},
                {
                        "Gentry Torres",
                        "gentrytorres@conferia.com",
                        "8665533942",
                        "Veniam cillum elit labore enim. Proident ullamco ipsum ut id aliquip id ad nostrud aliquip. Pariatur dolore esse occaecat adipisicing reprehenderit excepteur pariatur magna est commodo incididunt velit. Officia id mollit velit adipisicing reprehenderit aliquip.\r\n"
                },
                {
                        "Wilcox Kirby",
                        "wilcoxkirby@conferia.com",
                        "8974362501",
                        "Irure amet elit incididunt dolor. Eu nulla proident ex cupidatat. Do sunt eu ut et enim ex consequat non aute excepteur nisi.\r\n"
                }
        };
    }
}
