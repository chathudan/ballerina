function testReturnFromIf() (int) {
    int x = 5;
    int y = 10;

    if (x > 10) {
        if (y < 10) {
            return 0;
        }
    } else {
        return 100;
    }
}
