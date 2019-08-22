#Unit tests written in a separate class
#always import other class
#In the wprkspace Settings search test and enable pytest
#always include test prefix
import pytest
import mathlib

#name test after method you want to test
def test_calc_total():
    #call the method and set a variable to the value returned
   total = mathlib.calc_total(4,5)
   #use assert to verify the test
   assert total == 9
    
#repeat from second method
def test_calc_multiply():
   result =  mathlib.calc_multiply(10,3)
   assert result ==30






