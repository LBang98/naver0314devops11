import React from 'react';

const LadderResult = ({ results }) => {
    return (
        <div>
            <h1>사다리 결과</h1>
            <ul>
                {results.map((result, index) => (
                    <li key={index}>{index + 1} -> {result}</li>
                ))}
            </ul>
            <button onClick={() => window.location.reload()}>다시하기</button>
        </div>
    );
};

export default LadderResult;
