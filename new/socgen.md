

currencyMap = [{code:USD , value:91}, {code: , value:}]

 
export const valueConverter = () => {


    const [input, setInput] = useState([{code:'USD' , value:91}]);
    const [selectInput, setSelectedInput] = useState();
    const [userInput, setUserInput] = useState();
    const [convertedInput, setconvertedInput] = useState();

    const convertValue = () => {
        return userInput/selectInput;
    }

      return (
        <div>
            <input type='number' value={userInput} onChange={e => setUserInput(e.target.value)} />
            <Select>
                {input.map((val) => (
                    <Option value={val.code} onClick={e => setSelectedInput(val.value)}>{val.code}</Option>
                ))}
            </Select>
            <button onClick = convertValue()>Convert Value</button>
            {convertedInput && <div>convertedInput</div> }
            
        </div>
    )

  

}